<template>
  <div>
    <header>
      <TheHeaderNav />
    </header>
    <main class="container">
      <div class="row">
        <section class="col-9">

          <RouterView />
        </section>
        <aside class="col-3">
          <div v-if="$route.path !== '/signup'">
            <div v-if="store.loginTF === false">
              <LoginForm />
            </div>
            <div v-else>
              <SigninForm />
            </div>
            <TheFavList />

          </div>

        </aside>
      </div>
    </main>
    <footer>
      <TheFooter />
    </footer>
  </div>
</template>


<script setup>
import TheHeaderNav from "./components/common/TheHeaderNav.vue";
import TheFooter from "./components/common/TheFooter.vue";
import LoginForm from "./components/common/TheLoginForm.vue";
import TheFavList from "./components/common/TheFavList.vue";
import { useUserStore } from './stores/user'
import SigninForm from "./components/common/TheSigninForm.vue";
import { onBeforeUnmount, onMounted, ref,  } from "vue";

const user = ref({});


const store = useUserStore();

onMounted(() => {
  if (sessionStorage.getItem("user") !== null) {
    store.loginTF = true;
  }
})



</script>

<style scoped>
@font-face {
    font-family: 'EASTARJET-Medium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_231029@1.1/EASTARJET-Medium.woff2') format('woff2');
    font-weight: 500;
    font-style: normal;
}

@font-face {
    font-family: 'JalnanGothic';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_231029@1.1/JalnanGothic.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
</style>