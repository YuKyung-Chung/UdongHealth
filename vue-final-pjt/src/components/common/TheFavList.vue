<template>
    <div v-if="favList.length === 0" class="icon-text-container">
        <i class="bi bi-asterisk sameLine"></i>
        <p>로그인 부탁드려용~!</p><i class="bi bi-asterisk sameLine"></i>
    </div>
    <div v-else v-for="fav in favList">
        <h4>{{ fav }}</h4>
    </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue'
import { useUserStore } from '../../stores/user';
import axios from 'axios';
const userStore = useUserStore();
const favList = ref([]);
const user = ref({});

watchEffect(() => {
    if (userStore.loginTF === true) {
        user.value = JSON.parse(sessionStorage.getItem("user"));
        const URL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}`
        console.log(URL);
        axios.get(URL).then((res) => favList.value = res.data).catch((error) => console.log(error));
    } else {
        favList.value = [];
    }
})




</script>

<style scoped>
.sameLine {
    color: red;
}

.icon-text-container {
    display: flex;
    align-items: center;
}
</style>