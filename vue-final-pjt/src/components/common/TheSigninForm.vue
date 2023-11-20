<template>
    <div>
        <h4>{{ user.name }}님 반갑습니다.</h4>
        <!-- <h4>{{ user.email }}</h4> -->
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const user = ref({});

onMounted(() => {
    user.value = JSON.parse(sessionStorage.getItem("user"));
    console.log(user.value);
})




</script>

<style scoped></style>