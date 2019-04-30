<template>
<div>
    <form>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" v-model="name" :class="{'alert': name === ''}"><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" v-model="email" :class="{'alert': email === ''}"><br>

        <input type="checkbox" name="agree" id="agree" v-model="agree"><label for="agree">I Agree</label><br>

        <button type="submit" :disabled="! formComplete">Submit</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Agree?</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>{{ name }}</td>
                <td>{{ email }}</td>
                <td>{{ agree ? 'Yes' : 'No' }}</td>
            </tr>
        </tbody>
    </table>
</div>
</template>

<script>
export default {
    name: 'mailing-list',
    data() {
        return {
            name: '',
            email: '',
            agree: false
        }
    },
    computed: {
        formComplete(vm) {
            return vm.name !== '' && vm.email !== '' && vm.agree;
        }
    }
}
</script>


<style lang="scss" scoped>
    .alert {
        background-color: red;
    }
</style>
