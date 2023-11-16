<template>
    <div class="container">
        <RouterLink to="/kind">전체</RouterLink>
        |
        <RouterLink :to="{ path: '/kind/upperBody' }">상체</RouterLink>
        |
        <RouterLink to="/kind/lowerBody">하체</RouterLink>
        |
        <RouterLink to="/kind/core">복부</RouterLink>
        |
        <RouterView />
    </div>
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img :src="`src/${images[0]}`" class="d-block w-100" alt="image">
            </div>
            <div class="carousel-item" v-for="(image, index) in pImgs" :key="index">
                <img :src="`src/${image}`" class="d-block w-100" alt="image">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import _ from 'lodash';

const images = ["assets/yhC.png",
    "assets/ykC.png", "assets/yhC.png", "assets/ykC.png"]

const pImgs = _.cloneDeep(images).slice(1);
</script>

<style scoped>
a {
    text-decoration-line: none;
}
</style>