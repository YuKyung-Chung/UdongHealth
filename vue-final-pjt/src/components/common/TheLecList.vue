<template>
    <div class="list-container mx-5">
        <ol class="list-group list-group-numbered  px-2 py-2">
            <li class="list-group-item d-flex justify-content-between align-items-start p-4" v-for="lec in lecList" :key=lec.placeId>
              <div class="ms-2 me-auto" >
                <RouterLink :to="{ path: `/placeDetail/${lec.placeId}`}" > {{lec.공원명}} </RouterLink>
                <br>
                {{ lec.설치주소 }}
                <br>
                {{lec.distance}} km
              </div>
              <span class="badge bg-primary rounded-pill">14</span>
            </li>
        </ol>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const lecList = ref([]);

onMounted(() => {
    const lon = 127.0396029
    const lat = 37.501286
    const URL = import.meta.env.VITE_APP_API_PLACE_URL + "/find/" + lat + "/" + lon;
  
    axios.get(URL).then((res) =>
        lecList.value = res.data).catch((error) => console.log(error));
})



</script>

<style scoped>
.list-container{
    font-family: 'Pretendard-Regular';
}

a{
    text-decoration: none;
    /* color: black; */
    font-family: 'Pretendard-Regular';
}
</style>