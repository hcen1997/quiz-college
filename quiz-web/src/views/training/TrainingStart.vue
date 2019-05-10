//答题开始页面 选择答题数据库 难度 数量
<template>
  <div class="training-start">
    <div class="range">
      <dm-checkbox v-model="rangeValue" name="a" label="常识判断" :full-width="false"></dm-checkbox>
      <dm-checkbox v-model="rangeValue" name="a1" label="言语理解与表达" :full-width="false">B</dm-checkbox>
      <br>
      <dm-checkbox v-model="rangeValue" name="a2" label="A" full-width="false">C</dm-checkbox>
      <dm-checkbox v-model="rangeValue" name="a3" label="A" full-width="false">D-locked</dm-checkbox>
      <br>
      <dm-checkbox v-model="rangeValue" name="a4" label="A" full-width="false">E-locked</dm-checkbox>
      <dm-checkbox v-model="rangeValue" name="a5" label="A" full-width="false">F-locked</dm-checkbox>
    </div>
    <dm-button class="element">Back</dm-button>
<router-link to="/training/body">
    <dm-button class="element">start</dm-button>
    </router-link>
    <div class="difficalty">
      <dm-button color="black" class="element">Challenge</dm-button>
      <br>
      <dm-button class="element">Options</dm-button>
    </div>~
    <!-- 题目数量没有选定 默认为10个 -->
  </div>
</template>
<script>

import Vue from 'vue'
Vue.component('TrainingStart', {
  data: function () {
    return {
      rangeValue: false,
      fi: false
    }
  }
})
export default {
  name: 'TrainingStart',
  data () {
    return {
      rangeValue: false,
      fi: false
    }
  }
}
</script>

<style>
.range {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
}
.element {
  margin: 10pt 20pt;
}
.difficalty {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
}
</style>
