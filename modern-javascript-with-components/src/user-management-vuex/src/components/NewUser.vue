<template>
    <div class="new-user-component">
    <button id="new-user-button" v-on:click="enableForm" class="btn btn-primary">New User</button>
    <div id="edit-screen" v-if="enabled">
        <form v-on:submit.prevent="performSubmit">
            <div class="form-group">
                <label for="firstName">
                    First Name
                </label>
                <input type="text" id="firstName" name="firstName" v-model="user.firstName">
            </div>
            <div class="form-group">
                <label for="lastName">
                    Last Name
                </label>
                <input type="text" id="lastName" name="lastName" v-model="user.lastName">
            </div>
            <div class="form-group">
                <label for="title">
                    Title
                </label>
                <input type="text" id="title" name="title" v-model="user.title">
            </div>
            <div class="form-group">
                <label for="email">
                    Email Address
                </label>
                <input type="email" id="email" name="email" v-model="user.email">
            </div>
            <div class="form-group">
                <label for="enabled">
                    Enabled
                </label>
                <input type="checkbox" id="enabled" name="enabled" v-model="user.enabled">
            </div>
            <button type="submit" class="btn btn-default">Save</button>
            <button id="cancel-save" v-on:click.stop.prevent="closeForm" class="btn">Cancel</button>
        </form>
    </div>
    </div>
</template>

<style>
@import url( 'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' ); 
</style>


<script>
import userStore from '@/stores/user';

export default {
    name: 'new-user',
    data() {
        return {
            enabled: false,
            user: {
                id: 0,
                firstName: '',
                lastName: '',
                title: '',
                email: '',
                enabled: false
            }
        }
    },
    methods: {
        enableForm() {
            this.enabled = true;
        },
        performSubmit() {
            this.user.id = Math.floor(Math.random() * 1000);
            userStore.commit('addUser', this.user);
            this.closeForm();
        },
        closeForm() {
            this.enabled = false;
            this.user = this.user = {
                id: 0,
                firstName: '',
                lastName: '',
                title: '',
                email: '',
                enabled: false
            };
        }
    }
}
</script>
