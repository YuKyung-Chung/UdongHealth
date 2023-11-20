<template>
    <div v-if="favList.length ===0" class="icon-text-container" >
        <i class="bi bi-asterisk sameLine"></i><p>로그인 부탁드려용~!</p><i class="bi bi-asterisk sameLine"></i>
    </div>
    <div v-else v-for="fav in favList">
        <h4>{{ fav }}</h4>
    </div>
</template>

<script setup>
import {ref} from 'vue'

const favList = ref([]);

</script>

<style scoped>
.sameLine {
    color : red;
}
.icon-text-container {
    display: flex;
    align-items : center;   
}
</style>