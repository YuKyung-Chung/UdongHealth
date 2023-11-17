<template>
    <div class="container">
        <RouterLink to="/">Home</RouterLink>
        |
        <RouterLink to="/about">About us</RouterLink>
        |
        <RouterLink to="/search">Search</RouterLink>
        |
        <RouterLink to="/kind">Kind</RouterLink>
    </div>
    <div class="text-center">
        <h1 class="mainTitle">우리 동네 무료 헬스장</h1>
    </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'


const router = useRouter();

onMounted(() => {
    router.replace("/");
})

</script>

<style  scoped>
.container {
    margin-top: 10px;
    text-align: right;
}

a {
    text-decoration-line: none;
    color: #0C48A1;
}


.mainTitle {
    margin-top: 30px;
    display : inline-block;
    background: linear-gradient(to top, #54ddff 20%, transparent 30%);

}
</style>