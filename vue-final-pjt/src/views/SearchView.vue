<template>
    <div class="container">
        <div class="nav nav-underline" id="search-nav">
            <RouterLink class="nav-link" to="/search/place">일반 검색</RouterLink>
            <RouterLink class="nav-link" to="/search/fit">부위 검색</RouterLink>
            <RouterView />
        </div>

        <div v-if="placeStore.fitSearchTF === false">
            <h3>일반 검색 결과</h3>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th class="text-center">지역구</th>
                        <th class="text-center">동</th>
                        <th class="text-center">상세주소</th>
                        <th class="text-center">상세보기</th>
                        <th class="text-center">즐겨찾기</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-for="place in placeStore.limitStores.value" :key="place.placeId">
                        <td>{{ place.addressGu }}</td>
                        <td>{{ place.addressDong }}</td>
                        <td>{{ place.addressDetail }}</td>
                        <td><button class="btn btn-primary" @click="goDetail(place.placeId)" :placeId="place.placeId">상세보기</button></td>
                        <td><button class="btn btn-success" @click.stop.prevent=addFav(place.placeId)>등록하기</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-else>
            <h3>부위({{ placeStore.fitSearchName }}) 검색 결과</h3>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th class="text-center" >지역구</th>
                        <th class="text-center" >동</th>
                        <th class="text-center" >공원명</th>
                        <th class="text-center" >종류 수</th>
                        <th class="text-center" >설치운동기구 종류</th>
                        <th class="text-center">상세보기</th>
                        <th class="text-center">즐겨찾기</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-for="place in placeStore.searchPlaces.value" :key="place.placeId">
                        <td>{{ place.addressGu }}</td>
                        <td>{{ place.addressDong }}</td>
                        <td>{{ place.공원명 }}</td>
                        <td class="text-center">{{ place.cnt }}</td>
                        <td class="text-truncate">{{ place.설치운동기구종류 }}</td>
                        <td class="text-center"><button class="btn btn-primary" @click="goDetail(place.placeId)" :placeId="place.placeId">상세보기</button>
                        </td>
                        <td class="text-center"><button class="btn btn-success"  @click.stop.prevent=addFav(place.placeId)>등록하기</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
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

    if (userStore.favCount >=4) {
        alert("찜 등록은 4개까지만 가능합니다.")
        return;
    }

    const URL = import.meta.env.VITE_APP_API_FAVORITES_URL + `/${user.value.userId}/${placeId}`

    try {
        const response = await axios.post(URL)
        alert("찜 등록에 성공했습니다.")
        userStore.addFavTF = true;
    }
    catch (error) {
        alert(error.response.data.message);
    }


}


onMounted(async () => {
    router.push("/search/place")
    await placeStore.getPlaces();
    if (placeStore.places.length >= 20) {
        placeStore.limitStores.value = placeStore.places.slice(0, 20);
    } else {
        placeStore.limitStores.value = placeStore.places;
    }
    user.value = JSON.parse(sessionStorage.getItem("user"));

})

</script>

<style scoped>


#search-nav a{
    text-decoration-line: none;
    color: black;
    font-family: 'Pretendard-Regular';
    font-weight: 800;
}

table{
    text-align: center;
}

h3{
    font-family: 'Pretendard-Regular';
    font-weight: 800;
}
.btn-success {
    background-color : #2D7E32;
    border-color : #2D7E32;
}
</style>