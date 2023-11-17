<template>
    <div>
        <h1>헤이헤이</h1>
        <div id="map"></div>
        <h2>{{ KAKAOMAP_API_KEY }}</h2>
    </div>
</template>

<script setup>
import {ref, onMounted} from 'vue'

let map = null;

const KAKAOMAP_API_KEY = import.meta.env.VITE_APP_MAP_API_KEY;
</script>

<style  scoped>

</style>