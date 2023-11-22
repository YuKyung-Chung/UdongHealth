<template>
    <div class="row-auto">
        <label for="search">Search</label>
        <input type="text" class="form-control" id="search" v-model="keyword" placeholder="키워드를 쓰시오.">
    </div>
    <input type="radio" v-model="searchCondition" value="place_name" checked>공원이름
    <input type="radio" v-model="searchCondition" value="address_dong">지역(동)
    <div class="row-auto">
        <button type="submit" class="btn btn-primary mb-3" @keyup.enter.stop.prevent=searchPlace
            @click.stop.prevent=searchPlace>검색</button>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { usePlaceStore } from '../../stores/place';
import axios from 'axios'

const placeStore = usePlaceStore();
const keyword = ref("");
const searchCondition = ref("place_name");

const searchPlace = async () => {
    const URL = import.meta.env.VITE_APP_API_PLACE_URL + "/search";
    console.log(URL);
    console.log(keyword.value);
    console.log(searchCondition.value);
    try {
        const response = await axios.get(URL, {
            params: {
                key: searchCondition.value,
                word: keyword.value,
            }

        })
        placeStore.searchPlaces.value = response.data;
        console.log(placeStore.searchPlaces.value);
        keyword.value = "";
    }
    catch (error) {
        console.log(error);

    }
}   
</script>

<style scoped></style>