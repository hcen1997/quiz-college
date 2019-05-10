//答题结果页面
<template>
  <div class="training-result">
    <dm-heading class="element" tag="h1">Game completed!</dm-heading>

    <dm-heading class="element" tag="h1">{{bonusThing}}</dm-heading>

    <dm-heading tag="h4">Total questions: {{Total}}</dm-heading>
    <dm-heading tag="h4">Right answers: {{rightCount}}</dm-heading>
    <dm-heading class="element" tag="h4">Hint used: {{hintUsed}}</dm-heading>

    <dm-heading tag="h4">21XP</dm-heading>
    <dm-heading class="element" tag="h4">* Medel *</dm-heading>

    <dm-heading tag="h3">Total</dm-heading>
    <dm-heading class="element" tag="h1">26XP</dm-heading>

    <dm-progress-bar progress="50   "></dm-progress-bar>
    <dm-heading class="element" tag="small">50/100exp</dm-heading>

    <dm-heading tag="h1">Game saved</dm-heading>
    <dm-button class="okBtn">OK</dm-button>
  </div>
</template>

<style>
.training-result {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
}
</style>
