using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Capstone.TransactionLogging
{
    public class TransactionFileSqlLog
    {
        private string connectionstring;
        private const string SQL_RecordTransaction = "INSERT INTO transaction_log VALUES (@tx_type, @message, @initial_balance, @ending_balance, @timestamp);";

        public TransactionFileSqlLog(string connectionstring)
        {
            this.connectionstring = connectionstring;
        }

        public void RecordDeposit(decimal depositAmount, decimal finalBalance)
        {
            RecordTransaction("FEED MONEY", null, depositAmount, finalBalance);
        }

        public void RecordPurchase(string productName, string slotId, decimal initialBalance, decimal finalBalance)
        {
            RecordTransaction("PURCHASE", slotId + " - " + productName, initialBalance, finalBalance);
        }

        public void RecordCompleteTransaction(decimal initialAmount)
        {
            RecordTransaction("GIVE CHANGE", null, initialAmount, 0.0M);            
        }

        private void RecordTransaction(string transaction_type, string message, decimal initialBalance, decimal remainingBalance)
        {
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionstring))
                {
                    conn.Open();

                    SqlCommand cmd = new SqlCommand(SQL_RecordTransaction, conn);
                    cmd.Parameters.AddWithValue("@tx_type", transaction_type);
                    if (String.IsNullOrEmpty(message))
                    {
                        cmd.Parameters.AddWithValue("@message", DBNull.Value);
                    }
                    else
                    {
                        cmd.Parameters.AddWithValue("@message", message);
                    }
                    cmd.Parameters.AddWithValue("@initial_balance", initialBalance);
                    cmd.Parameters.AddWithValue("@ending_balance", remainingBalance);
                    cmd.Parameters.AddWithValue("@timestamp", DateTime.UtcNow);
                    cmd.ExecuteNonQuery();
                }
            }
            catch (SqlException ex)
            {
                Console.WriteLine("An error has occurred recording the transaction: " + ex.Message);
            }
        }

    }
}
