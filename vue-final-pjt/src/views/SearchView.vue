<template>
    <RouterLink to="/search/place">일반 검색</RouterLink>
    <RouterLink to="/search/fit">부위 검색</RouterLink>
    <RouterView />
    
    
    <h2>여기는 항상 실행됩니다.</h2>
    <table border="1">
        <th>지역구</th>
        <th>동</th>
        <th>상세주소</th>
        <th>찜버튼</th>
        <tr v-for="place in placeStore.searchPlaces.value" :key="place.placeId">
            <td>{{ place.addressGu }}</td>
            <td>{{ place.addressDong }}</td>
            <td>{{ place.addressDetail }}</td>
            <td><button @click="goDetail(place.placeId)" :placeId="place.placeId">상세보기</button></td>
            <td><button @click.stop.prevent=addFav(place.placeId)>찜 등록</button></td>
        </tr>

    </table>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { usePlaceStore } from '../stores/place';
import { useUserStore } from '../stores/user';
import axios from 'axios';
const userStore = useUserStore();
const placeStore = usePlaceStore();

const router = useRouter();
const user = ref({});

const goDetail = (placeId) => {
    router.push({ name: 'placeDetail', params: { placeId: placeId } })
}




const addFav = async (placeId) => {
    if (userStore.loginTF === false) {
        alert("찜 기능을 사용할려면 로그인 해주세요")
        return;
    }
    const URL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}/${placeId}`

    try {
        const response = axios.post(URL)
        alert("찜 등록에 성공했습니다.")
        userStore.addFavTF = true;
    }
    catch (error) {
        console.log(error);
    }


}


onMounted(async () => {
    router.push("/search/place")
    await placeStore.getPlaces();
    if (placeStore.places.length >= 20) {
        placeStore.searchPlaces.value = placeStore.places.slice(0, 20);

    } else {
        placeStore.searchPlaces.value = placeStore.places;
    }
    user.value = JSON.parse(sessionStorage.getItem("user"));

})

</script>

<style scoped></style>