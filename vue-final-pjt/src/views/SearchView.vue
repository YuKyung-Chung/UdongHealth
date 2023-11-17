<template>
    <form class="col">
        <div class="row-auto">
            <label for="search">Search</label>
            <input type="text" class="form-control" id="search" placeholder="키워드를 쓰시오.">
        </div>
        
        <div class="row-auto">
            <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent>검색</button>
        </div>
        
    </form>
    
    <!-- <div v-for="place in store.places" :key="place.placeId">
    <h4>{{ place }}</h4>
    </div> -->
</template>

<script setup>
import { onMounted} from 'vue'
import { usePlaceStore } from '../stores/place';

onMounted(() => {
    const store = usePlaceStore();
    store.getPlaces();
    console.log(store.places);

})

</script>

<style scoped></style>