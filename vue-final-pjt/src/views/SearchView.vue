<template>
    <form class="col">
        <div class="row-auto">
            <label for="search">Search</label>
            <input type="text" class="form-control" id="search" placeholder="키워드를 쓰시오.">
        </div>
        <input type="radio" name="searchCondition" value="공원이름" checked>공원이름
        <input type="radio" name="searchCondition" value="지역(동)">지역(동)
        <input type="radio" name="searchCondition" value="운동부위">(운동부위)
        <div class="row-auto">
            <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent>검색</button>
        </div>

    </form>
    <table border="1">
            <th>지역구</th>
            <th>동</th>
            <th>상세주소</th>
        <tr v-for="place in limitPlace" :key="place.placeId">
                <td>{{ place.addressGu }}</td>
                <td>{{ place.addressDong }}</td>
                <td>{{ place.addressDetail }}</td>
                <td><button @click="goDetail(place.placeId)" :placeId="place.placeId">상세보기</button></td>
        </tr>

    </table>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { usePlaceStore } from '../stores/place';
const store = usePlaceStore();
const limitPlace = ref([]);
const router = useRouter();
const goDetail = (placeId) => {
    router.push({name: 'placeDetail', params: {placeId : placeId}})
}





onMounted(async () => {
    await store.getPlaces();
    if (store.places.length >=20) {
        limitPlace.value = store.places.slice(0, 20);

    } else {
        limitPlace.value = store.places;
    }

})

</script>

<style scoped></style>