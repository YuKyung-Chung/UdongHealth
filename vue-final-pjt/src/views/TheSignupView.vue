<template>
    <div>
        회원가입
        <form>
            <label for="name">닉네임</label>
            <input type="text" v-model="name" id="name" placeholder="닉네임" />
            <br>
            <br>
            <label for="email">이메일</label>
            <input type="email" v-model="email" id="email" placeholder="아이디" />
            <br>
            <br>
            <label for="pw">패스워드</label>
            <input type="password" v-model="pw" id="pw" placeholder="비밀번호" />
            <br>
            <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent=signupId>제출</button>
        </form>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue'
import router from '../router';

const name = ref("");
const email = ref("");
const pw = ref("");

const signupId = async () => {
    const signUp = { name: name, email: email, password: pw };
    const URL = import.meta.env.VITE_APP_API_URL + "/" + "signup";
    console.log(URL);
    axios
        .post(URL, signUp)
        .then((res) => {

            console.log(res)
            alert("회원가입 완료!, 로그인 해주세요");
        })
        .catch((res) => {
            alert("아이디 중복입니다. 다른 아이디를 사용해주세요")
            console.log(res);
        })


    // await axios.post(URL, signUp, 
    // ).then((res) => {
    //     alert("회원가입 완료!, 로그인 해주세요");
    //     router.replace("/")
    // }).catch((res) => {
    //     alert("아이디 중복입니다. 다른 아이디를 사용해주세요")
    //     router.replace("/signup");
    // })

}
</script>

<style scoped></style>