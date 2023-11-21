import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
  const user = ref({});
  const loginTF = ref(false);
  const addFavTF = ref(false);
  const saveUser = (loginUser) => {
    user.value = loginUser;
    
  }
  return { user, saveUser, loginTF, addFavTF }
})
