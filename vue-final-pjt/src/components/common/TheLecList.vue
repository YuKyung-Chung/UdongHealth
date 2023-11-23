<template>
    <div>
        <div v-for="lec in lecList" :key=lec.placeId>
            <RouterLink :to="{ path: `/placeDetail/${lec.placeId}`}" > {{lec.공원명}} </RouterLink>
        </div>
        
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

<style scoped></style>