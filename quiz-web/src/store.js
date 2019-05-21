import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    questionArray: [],
    person: [],
    test: {
      isFirstTime: true,
      firstRightCount: 0
    }
  }
})
