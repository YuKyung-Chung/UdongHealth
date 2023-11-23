<template>
    <div class="favListClass">
    <div v-if="userStore.loginTF === false" class="icon-text-container row">
        <h4 class="mt-3"> 오늘의 운동 상식 </h4>
        <div v-for="art in arts">
            
            <p>{{ art.content }}</p>
            <p class="writer">{{ art.writer }}</p>
        </div>
    </div>
    <div v-else>
        <div v-if="favList.length === 0">
            <p>아직 찜 목록이 없습니다.</p>
        </div>
        <div v-else>
            <h3> 즐겨찾는 장소</h3>
            <div v-for="fav in favList" class="p-3 my-3 border-bottom border-end  border-2 border-secondary shadow rounded">
                <RouterLink :to="`/placeDetail/${fav.placeId}`">
                    <h5>{{ fav.addressGu }} {{ fav.addressDong }} {{ fav.공원명 }}</h5>
                </RouterLink>
                <div>
                    <p> {{ fav.설치운동기구종류 }}</p>
                    <button class="btn btn-danger" @click="deleteFav(fav.placeId)">삭제</button>
                </div>
            </div>
            
        </div>
    </div>

    </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useUserStore } from '../../stores/user';
import axios from 'axios';
const userStore = useUserStore();
const favList = ref([]);
const user = ref({});

const deleteFav = async(placeId) => {
    const deleteURL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}/${placeId}` 
    try {
        await axios.delete(deleteURL);
        userStore.favCount--;
        favList.value = favList.value.filter(item => item.placeId !== placeId);
    } catch(error) {
        console.log(error);
    }
}


watch([() => userStore.loginTF, () => userStore.addFavTF], async () => {
    if (userStore.loginTF === true) {
        user.value = JSON.parse(sessionStorage.getItem("user"));

        const URL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}`;
        try {
            const response = await axios.get(URL);
            favList.value = response.data;
            userStore.favCount = favList.value.length;
            favList.value.forEach((item) => {
                const arr = item.설치운동기구종류.split(",");
                if (arr.length >= 3) {
                    item.설치운동기구종류 = `${arr[0]}, ${arr[1]}, ${arr[2]}, 등...`
                }
            })
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

const arts = [{
    writer: "SSAFY",
    content: "복식 호흡의 중요성 알고 계신가요?...",

}, {
    writer: "조용환",
    content: "무료 헬스장 100배 즐기기",
}, {
    writer: "정유경",
    content: "실외 운동기구별 사용법 일타 강의"
}]


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
    margin-bottom: 4px
}

.writer {
    font-weight: 700;
    color: #1E88E5
}

a {
    text-decoration: none;
}

.favListClass {
    font-family: 'Pretendard-Regular';
}
</style>