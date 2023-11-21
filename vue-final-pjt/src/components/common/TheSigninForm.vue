<template>
    <div>
        <h4>{{ user.name }}님 반갑습니다.</h4>
        <!-- <h4>{{ user.email }}</h4> -->
    </div>
    <br>
    <div>
        <button class="btn btn-primary mb-3" @click.stop.prevent=logout>로그아웃</button>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import router from '../../router';
import {useUserStore} from '@/stores/user'


const store = useUserStore();
const user = ref({});

const logout = () => {
    
    store.loginTF = false;
    sessionStorage.removeItem("user")
    alert("로그아웃 되었습니다")
    router.replace("/")
    
}


onMounted(() => {
    user.value = JSON.parse(sessionStorage.getItem("user"));
})




</script>

<style scoped></style>