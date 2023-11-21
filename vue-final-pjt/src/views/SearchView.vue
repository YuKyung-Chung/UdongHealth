<template>
    <form class="col">
        <div class="row-auto">
            <label for="search">Search</label>
            <input type="text" class="form-control" id="search" v-model="keyword" placeholder="키워드를 쓰시오.">
        </div>
        <input type="radio" v-model="searchCondition" value="plac_Name" checked>공원이름
        <input type="radio" v-model="searchCondition" value="address_dong">지역(동)
        <input type="radio" v-model="searchCondition" value="fitPart">(운동부위)
        <div class="row-auto">
            <button type="submit" class="btn btn-primary mb-3" @keyup.enter.stop.prevent=searchPlace @click.stop.prevent=searchPlace>검색</button>
        </div>
    </form>
    <table border="1">
        <th>지역구</th>
        <th>동</th>
        <th>상세주소</th>
        <th>찜버튼</th>
        <tr v-for="place in limitPlace" :key="place.placeId">
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
const limitPlace = ref([]);
const router = useRouter();
const user = ref({});
const keyword = ref("");
const searchCondition = ref("place_name");
const goDetail = (placeId) => {
    router.push({ name: 'placeDetail', params: { placeId: placeId } })
}
const searchPlace = async() => {
    const URL = import.meta.env.VITE_APP_API_PLACE_URL +"/search";
    console.log(URL);
    console.log(keyword.value);
    console.log(searchCondition.value);
    try {
        const response = await axios.get(URL, {
            params: {
                key : searchCondition.value,
                word : keyword.value,
            }
      
        })
        limitPlace.value = response.data;
        console.log(response.data);
        keyword.value = "";
    }
    catch (error){
        console.log(error);

    }
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
    await placeStore.getPlaces();
    if (placeStore.places.length >= 20) {
        limitPlace.value = placeStore.places.slice(0, 20);

    } else {
        limitPlace.value = placeStore.places;
    }
    user.value = JSON.parse(sessionStorage.getItem("user"));

})

</script>

<style scoped></style>