<template>
    <div v-if="favList.length === 0" class="icon-text-container">
        <i class="bi bi-asterisk sameLine"></i>
        <p>로그인 부탁드려용~!</p><i class="bi bi-asterisk sameLine"></i>
    </div>
    <div v-else v-for="fav in favList">
        <h4>{{ fav.placeId }}</h4>
    </div>
</template>

<script setup>
import { ref, watch, watchEffect } from 'vue'
import { useUserStore } from '../../stores/user';
import axios from 'axios';
import router from '../../router';
const userStore = useUserStore();
const favList = ref([]);
const user = ref({});


watch([() => userStore.loginTF, () => userStore.addFavTF], async () => {
    if (userStore.loginTF === true) {
        user.value = JSON.parse(sessionStorage.getItem("user"));

        const URL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}`;
        try {
            const response = await axios.get(URL);
            favList.value = response.data;
        } catch (error) {
            console.error('Error fetching data:', error);
        }

    } else {
        favList.value = [];
    }

    // addFavTF가 true일 때만 수행하도록 변경
    if (userStore.addFavTF) {
        userStore.addFavTF = false;
    }
});




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