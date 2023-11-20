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
import { onBeforeUnmount, ref,  } from "vue";

const user = ref({});


const store = useUserStore();




onBeforeUnmount(() => {
  sessionStorage.removeItem("user");
  store.loginTF = false;
})
</script>

<style scoped></style>