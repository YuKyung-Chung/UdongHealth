
<template>
    <div>
        <form>
            <label for="content">컨텐츠</label>
            <input type="text" v-model="content" id="content" placeholder="content" />
            <br>
            <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent=reviewCreate
                @keyup.enter.stop.prevent=reviewCreate>제출</button>
        </form>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { usePlaceStore } from '../../stores/place';
import axios from 'axios';
import router from '../../router';

const user = ref({});
const content = ref("");
const store = usePlaceStore();
const review = ref({});

const reviewCreate = async () => {
   
    const URL = import.meta.env.VITE_APP_API_REVIEW_URL + `/${store.reviewPlaceId}`
    console.log(URL);
    try {
        const response = await axios.post(URL, {
            userId: user.value.userId,
            placeId: store.reviewPlaceId,
            writer: user.value.name,
            content: content.value,
        })
    } catch(error) {
        console.log(error);
    }
    
    router.replace(`/placeDetail/${store.reviewPlaceId}`)
}



// store.reviewPlaceId


onMounted(() => {
    user.value = JSON.parse(sessionStorage.getItem("user"));
})
</script>

<style scoped></style>