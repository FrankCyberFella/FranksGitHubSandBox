<template>
    <div class="user-management">
        <form>
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" name="firstName" id="firstName"
                <!-- Start remove -->
                v-model="firstName"
                <!-- End remove -->
                >
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" name="lastName" id="lastName"
                <!-- Start remove -->
                v-model="lastName"
                <!-- End remove -->
                >
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <div class="button-group">
                    <label>
                        <input type="radio" name="gender" value="m"
                        <!-- Start remove -->
                        v-model="gender"
                        <!-- End remove -->
                        >
                        Male
                    </label>
                    <label>
                        <input type="radio" name="gender" value="f"
                        <!-- Start remove -->
                        v-model="gender"
                        <!-- End remove -->
                        >
                        Female
                        </label>
                    <label>
                        <input type="radio" name="gender" value="o"
                        <!-- Start remove -->
                        v-model="gender"
                        <!-- End remove -->
                        >
                        Other
                        </label>
                </div>
            </div>
            <div class="form-group">
                <label>Role</label>
                <select name="role"
                <!-- Start remove -->
                v-model="role"
                <!-- End remove -->
                >
                    <option value="" disabled>-- Select One --</option>
                    <option value="admin">Adminstrator</option>
                    <option value="staff">Staff Member</option>
                    <option value="volunteer">Volunteer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="disabled">
                    Disabled
                </label>
                <input type="checkbox" name="disabled" id="disabled"
                <!-- Start remove -->
                v-model="disabled"
                <!-- End remove -->
                >
            </div>
            <div class="form-group">
            <label>Extra Permissions</label>
                <div class="button-group">
                    <label>
                        <input type="checkbox" name="permissions" value="w"
                        <!-- Start remove -->
                        v-model="permissions"
                        <!-- End remove -->
                        >
                        Write
                    </label>
                    <label>
                        <input type="checkbox" name="permissions" value="x"
                        <!-- Start remove -->
                        v-model="permissions"
                        <!-- End remove -->
                        >
                        Execute
                    </label>
                    <label>
                        <input type="checkbox" name="permissions" value="d"
                        <!-- Start remove -->
                        v-model="permissions"
                        <!-- End remove -->
                        >
                        Delete
                    </label>
                </div>
            </div>
            <div class="form-group center">
            <h3>Other Notes</h3>
            <textarea name="notes" cols="60" rows="10"
            <!-- Start remove -->
            v-model="notes"
            <!-- End remove -->
            ></textarea>
            </div>
        </form>

        <table>
            <thead>
                <tr>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Gender</td>
                    <td>Role</td>
                    <td>Disabled</td>
                    <td>Permissions</td>
                    <td>Notes</td>
                </tr>
            </thead>
            <tbody>
    <tr>
        <!-- Start remove -->
        <td>{{ firstName }}</td>
        <td>{{ lastName }}</td>
        <td>{{ gender }}</td>
        <td>{{ role }}</td>
        <td>{{ disabled }}</td>
        <td>{{ permissions }}</td>
        <!-- In order to see multiline text from the textarea, wrap in pre -->
        <td><pre>{{ notes }}</pre></td>
        <!-- End remove -->
    </tr>
</tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: "user-management",
    // Start remove
    data() {
        return {
            firstName: '',
            lastName: '',
            gender: '',
            disabled: false,
            permissions: [],
            role: '',
            notes: ''
        }
    }
    // End remove
}
</script>

<style lang="scss" scoped>
    div.user-management {
        width: 800px;
        margin: auto;

        div.form-group {
            padding: 0.25em;

            label {
                width: 45%;
                display: inline-block;
                font-weight: bold;
                text-align: right;
                padding-right: 1em;
                vertical-align: top;
            }
            input[type=text], select {
                width: 45%;
            }

            div.button-group {
                text-align: left;
                display: inline-block;
                width: 45%;

                label {
                    width: 100%;
                    text-align: left;
                }
            }
        }

        table {
            max-width: 100%;
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;

            > thead,
            > tbody,
            > tfoot {
                > tr {
                    > th,
                    > td {
                        padding: 0.25em;
                        vertical-align: top;
                        border-top: 1px solid lightgray;
                    }
                }
            }
            // Bottom align for column headings
            > thead > tr > th {
                vertical-align: bottom;
                border-bottom: 2px solid gray;
            } 
        }
    }

    .center {
        text-align: center;
    }
</style>
