<template>
    <div v-if="userStore.loginTF === false" class="icon-text-container row" >
        <h4> 오늘의 운동 상식 </h4>
        <div v-for="art in arts">
            
            <p>{{ art.content}}</p>
            <p class="writer">{{ art.writer }}</p>
        </div>
    </div>
    <div v-else>
        <div v-if="favList.length ===0">
            <p>아직 찜 목록이 없습니다.</p>
        </div>
        <div v-else v-for="fav in favList">
            <h4>{{ fav.placeId }}</h4>
        </div>

    </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useUserStore } from '../../stores/user';
import axios from 'axios';
import router from '../../router';
const userStore = useUserStore();
const favList = ref([]);
const user = ref({});
const arts = [{
    writer : "SSAFY",
    content : "복식 호흡의 중요성 알고 계신가요?...",

}, {
    writer : "조용환",
    content : "무료 헬스장 100배 즐기기",
}]


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
    color: black;
}

.icon-text-container {
    display: flex;
    align-items: center;
}
p {
    margin-bottom : 4px
}
.writer {
    font-weight : 700;
    color : #1E88E5 
}
</style>