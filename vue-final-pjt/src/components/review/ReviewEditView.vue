<template>
    <div>
        <h2> 리뷰 수정 여기서 할게요</h2>

    </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { useUserStore } from '../../stores/user';
import router from '../../router';
const store = useUserStore();

onMounted(() => {
    if (store.loginTF === false) {
        alert("로그인을 먼저해주세요.");
        router.replace("/");
    }
})

</script>

<style scoped>

</style>