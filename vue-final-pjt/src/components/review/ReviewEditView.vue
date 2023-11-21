<template>
    <div>
        <h2> 리뷰 수정 여기서 할게요</h2>
        <form class="col">
            <div class="row-auto">
                <label for="reviewContent">리뷰입력칸</label>
                <input type="text" v-model="content" class="form-control" id="reviewContent"
                    placeholder="리뷰입력칸">
            </div>
            <div class="row-auto">
                <button type="submit" class="btn btn-primary mb-3" @click.stop.prevent=reviewEdit
                    @keyup.enter.stop.prevent=reviewEdit>로그인</button>
            </div>

        </form>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useUserStore } from '../../stores/user';
import { usePlaceStore } from '../../stores/place';
import axios from 'axios'
import router from '../../router';
const userStore = useUserStore();
const placeStore = usePlaceStore();
const content = ref("");
const reviewEdit = async () => {
    const URL = import.meta.env.VITE_APP_API_REVIEW_URL + "/" + placeStore.reviewPlaceId + "/" + router.params.review.reviewId;
    
    

    router.push(`/placeDetail/${placeStore.reviewPlaceId}`)
}



onMounted(() => {
    if (userStore.loginTF === false) {
        alert("로그인을 먼저해주세요.");
        router.replace(`/placeDetail/${placeStore.reviewPlaceId}`)
    }
    content.value = router.params.review.content
})

</script>

<style scoped></style>