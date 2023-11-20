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

const user = ref({});
const content = ref("");
const store = usePlaceStore();
const review = ref({});

const reviewCreate = async () => {
    review.value = {
        content: content,
        placeId: store.reviewPlaceId,
        userId: user.value.userId,
        writer: user.value.name,

    }
    const URL = import.meta.env.VITE_APP_API_URL + `/${store.reviewPlaceId}`
    axios.
        POST(URL, review.value).then((res) => {
            alert("등록이 완료되었습니다.")
        })
}

}

store.reviewPlaceId


onMounted(() => {
    user.value = JSON.parse(sessionStorage.getItem("user"));
})
</script>

<style lang="scss" scoped></style>