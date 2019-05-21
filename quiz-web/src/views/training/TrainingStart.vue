//答题开始页面 选择答题数据库 难度 数量
<template>
  <div class="training-start">
    <div class="range">
      <!-- 不用dm-checkbox 因为v-model没有更改了设定 -->
      <input type="checkbox" v-model="category" value="常识判断" id="c1">
      <label for="c1">常识判断&numsp;</label>
      <input type="checkbox" v-model="category" value="言语理解与表达" id="c2">
      <label for="c2">言语理解与表达</label><br>
      <input type="checkbox" v-model="category" value="数量关系" id="c3">
      <label for="c3">数量关系&numsp;</label>
      <input type="checkbox" v-model="category" value="判断推理" id="c4">
      <label for="c4">判断推理&numsp;&numsp;&numsp;&numsp;&numsp;</label><br>
      <input type="checkbox" v-model="category" value="资料分析" id="c5">
      <label for="c5">资料分析&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;&numsp;</label>
    </div>
    <router-link to="/">
      <dm-button class="element">返回</dm-button>
    </router-link>
    <dm-button class="element" v-on:click="queryList">开始</dm-button>
    <div class="difficalty">
      <dm-button color="black" class="element">&numsp;&numsp;数量&numsp;&numsp;</dm-button>
      <br>
      <dm-button class="element">&numsp;&numsp;难度&numsp;&numsp;</dm-button>
    </div>
    <!-- 题目数量没有选定 默认为10个 -->
  </div>
</template>
<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  name: 'TrainingStart',
  data () {
    return {
      category: ['常识判断'],
      error: ''
    }
  },
  methods: {
    queryList () {
      let catStr = this.category.join('|')
      this.$axios
        .get('/question/list', {
          params: {
            quantity: 10,
            category: catStr
          }
        })
        .then(queList => {
          let queArray = []
          for (let i = 0; i < queList.data.length; i++) {
            let queObj = queList.data[i]
            let queStatus = { isAnswered: false, isAnsRight: false, isNeedAns: true }
            queArray.push({ queObj, queStatus })
          }
          this.$store.state.test.firstRightCount = 0
          this.$store.state.test.isFirstTime = true
          Vue.set(store.state, 'questionArray', queArray)
          this.$router.push('/training/body')
        })
        .catch(error => {
          this.error = error
        })
    }
  }
}
</script>

<style>
.range {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
  font-size: 20px;
  line-height: 27px;
  padding-top: 5px;
  padding-bottom: 5px;
}
.element {
  margin: 10pt 20pt;
}
.difficalty {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
}
label {
  color: azure;
}
</style>
