<template>
    <div>
        <img v-for="(image, index) in images" :key="image.alt" :src="image.src" width="100" :alt="image.alt" @click.stop.prevent="handleImageClick(index)" />
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { usePlaceStore} from '../../stores/place'
import axios from 'axios';

const placeStore = usePlaceStore();

const handleImageClick = async(index) => {
    placeStore.fitSearchTF = true;
    const URL = import.meta.env.VITE_APP_API_PLACE_URL + `/search/${images[index].alt}`
    const response = await axios.get(URL);
    placeStore.fitSearchName = images[index].alt;
    placeStore.searchPlaces.value = response.data;
    placeStore.searchPlaces.value.forEach(item => {
    if (item.설치운동기구종류 && item.설치운동기구종류.length > 20) {
        // 만약 kind 속성의 길이가 20을 초과하면 20자로 자름
        item.설치운동기구종류 = item.설치운동기구종류.slice(0, 22) + "...";
    }
});
}

const images = [{
    src : "../src/assets/fit/body.png",
    alt : "온몸"
}, {
    src : "../src/assets/fit/upperBody.png",
    alt : "상체"
}, {
    src : "../src/assets/fit/waist.png",
    alt : "허리"
}, {
    src : "../src/assets/fit/chest.png",
    alt : "가슴" 
},{
    src : "../src/assets/fit/belly.png",
    alt : "배"
}, {
    src : "../src/assets/fit/shoulder.png",
    alt : "어깨"
}, {
    src : "../src/assets/fit/back.png",
    alt : "등"
}, {
    src : "../src/assets/fit/arm.png",
    alt : "팔"
}, {
    src : "../src/assets/fit/leg.png",
    alt : "하체"
}, {
    src : "../src/assets/fit/endurance.png",
    alt : "지구력"
}, {
    src : "../src/assets/fit/weight.png",
    alt : "웨이트"
}, {
    src : "../src/assets/fit/cardio.png",
    alt : "유산소"
}, {
    src : "../src/assets/fit/stretching.png",
    alt : "스트레칭"
}, {
    src : "../src/assets/fit/flexibility.png",
    alt : "유연성"
}]



</script>

<style scoped>

</style>