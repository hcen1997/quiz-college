<template>
    <div class="hc-box">
      <router-link to="/person">
      <dm-button v-on:click="addExp">点击这个按钮 让你变强</dm-button>
      </router-link>
      <router-link to="/person">
        <dm-button v-on:click="addExpandUpdate">点击这个按钮 让你真的变强</dm-button>
      </router-link>
    </div>
</template>

<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  name: 'Test',
  methods: {
    addExp () {
      this.$store.state.person.exp += 8
    },
    addExpandUpdate: function () {
      this.$store.state.person.exp += 8
      this.$axios
        .post('/person/updateExp',
          {
            name: '小明',
            exp: this.$store.state.person.exp
          })
        .then(res => {
          let intt = res.data
          if (intt === 1) {
          }
        })
        .catch(error => {
          console.log('error')
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>

</style>
