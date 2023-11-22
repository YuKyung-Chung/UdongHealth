<template>
    <div>
        <button type="button" class="btn btn-primary" @click.stop.prevent="handleFitPartClick(`All`)">전체</button>
        |
        <button type="button" class="btn btn-primary" @click.stop.prevent="handleFitPartClick(`upperBody`)">상체</button>
        |
        <button type="button" class="btn btn-primary" @click.stop.prevent="handleFitPartClick(`lowerBody`)">하체</button>
        |
        <button type="button" class="btn btn-primary" @click.stop.prevent="handleFitPartClick(`core`)">복부</button>
        |
    </div>
    <div class="text-center kindView">
        <div v-if="fitPart === 'All'">
            <TheKindCarousel :fitPart="'All'" />
        </div>
        <div v-else-if="fitPart === 'upperBody'">
            <TheKindCarousel :fitPart="'upperBody'" />
        </div>
        <div v-else-if="fitPart === 'lowerBody'">
            <TheKindCarousel :fitPart="'lowerBody'" />
        </div>
        <div v-else>
            <TheKindCarousel :fitPart="'core'" />
        </div>
    </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import _ from 'lodash';
import { useRouter } from 'vue-router'
import TheKindCarousel from '../components/common/TheKindCarousel.vue'
const firstImage = ref({});
const fitPart = ref("All")
const images = ref([]);
const pImgs = ref([]);

const handleFitPartClick = (fitname) => {
    fitPart.value = fitname;

}





</script>

<style scoped>
a {
    text-decoration-line: none;
}
.kindView {
    height : 78vh;
}
.btn-primary {
    background-color : #2D7E32;
    border-color : #2D7E32;
}
</style>
