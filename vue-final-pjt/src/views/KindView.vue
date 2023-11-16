<template>
    <div class="container">
        <RouterLink to="/kind">전체</RouterLink>
        |
        <RouterLink :to="{ path: 'upperBody' }">상체</RouterLink>
        |
        <RouterLink :to="{ path: 'lowerBody' }">하체</RouterLink>
        |
        <router-link :to="{ path: 'relative/core' }">복부</router-link>
        |
        <RouterView />

    </div>
    <VueSlickCarousel v-bind="settings">
        <div>
            <h3>1</h3>
        </div>
        /*...*/
    </VueSlickCarousel>
</template>

<script setup>
import VueSlickCarousel from 'vue-slick-carousel';
import 'vue-slick-carousel/dist/vue-slick-carousel.css';
import 'vue-slick-carousel/dist/vue-slick-carousel-theme.css';

const settings= {
    arrows: true,
    dots: true,
}

</script>

<style scoped>
a {
    text-decoration-line: none;
}

.pd16 {
    padding: 16px;
}

.card {
    height: 250px;
    background: pink;
    border-radius: 8px;
    color: #fff;
    text-align: center;
}
</style>