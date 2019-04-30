using Capstone.Classes;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Capstone.Inventory
{
    public class InventorySqlDAL
    {
        const int InitialQuantity = 5;
        private string connectionString;
        public InventorySqlDAL(string connectionString)
        {
            this.connectionString = connectionString;
        }

        public Dictionary<string, List<VendingMachineItem>> GetInventory()
        {
            Dictionary<string, List<VendingMachineItem>> output = new Dictionary<string, List<VendingMachineItem>>();

            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    conn.Open();

                    SqlCommand cmd = new SqlCommand("SELECT * FROM inventory ORDER BY slot_Id", conn);
                    SqlDataReader reader = cmd.ExecuteReader();
                    while (reader.Read())
                    {
                        string slotid = Convert.ToString(reader["slot_id"]);
                        string name = Convert.ToString(reader["product_name"]);
                        decimal cost = Convert.ToDecimal(reader["cost"]);
                        string type = Convert.ToString(reader["product_type"]);

                        output.Add(slotid, GetInitialStock(name, cost, type));
                    }
                }

            }
            catch (SqlException ex)
            {
                Console.WriteLine("An error occurred reading the invnentory table. " + ex.Message);
                throw;
            }


            return output;
        }

        private List<VendingMachineItem> GetInitialStock(string name, decimal cost, string type)
        {
            Dictionary<string, Type> types = new Dictionary<string, Type>()
            {
                {"Chip", typeof(ChipItem) },
                {"Candy", typeof(CandyItem) },
                {"Pop", typeof(BeverageItem) },
                {"Gum", typeof(GumItem) }
            };

            Type typeToCreate = types[type];
            List<VendingMachineItem> initialStock = new List<VendingMachineItem>();
            for (int i = 0; i < InitialQuantity; i++)
            {
                initialStock.Add((VendingMachineItem)Activator.CreateInstance(typeToCreate, name, cost));
            }

            return initialStock;
        }
    }
}
