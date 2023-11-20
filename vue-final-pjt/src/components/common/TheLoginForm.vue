<template>
    <form class="col">
        <div class="row-auto">
            <label for="inputId1">Email</label>
            <input type="text" v-model="inputId1" class="form-control" id="staticId1" placeholder="id">
        </div>
        <div class="row-auto">
            <label for="inputPassword1">Password</label>
            <input type="password" v-model="inputPassword1" class="form-control" id="inputPassword1" placeholder="Password">
        </div>

        <div class="row-auto">
            <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent=signIn
                @keyup.enter.stop.prevent=signIn>로그인</button>
            <RouterLink to="/signup"> 회원가입 </RouterLink>
        </div>

    </form>
</template>

<script setup>
import { ref } from 'vue'
import { useUserStore } from '@/stores/user';
import axios from 'axios';
import router from "@/router";
const inputId1 = ref("");
const inputPassword1 = ref("");
const store = useUserStore();

const signIn = async () => {
    const URL = import.meta.env.VITE_APP_API_URL + "/" + "login";

    axios.
        post(URL, {
            email: inputId1.value,
            password: inputPassword1.value,
        }).then((res) => {
            sessionStorage.setItem("user", JSON.stringify(res.data));
            store.loginTF = true;
            alert("로그인 되었습니다!")
            router.replace("/");
        }).catch((error) => {

            alert(error.response.data.message);
        })


}

</script>

<style scoped>
.btn {
    margin-top: 5px;
}
</style>