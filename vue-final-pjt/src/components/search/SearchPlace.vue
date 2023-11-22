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

</script>

<style scoped></style>