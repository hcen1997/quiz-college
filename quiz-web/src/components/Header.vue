<template>
    <div style="color: aliceblue">
        {{systemName}}问答系统
    </div>
</template>
<script>
export default {
  name: 'Header',
  props: {
    systemName: String
  }
}
</script>
WebView webView = new WebView(this);
webView.getSettings( ).setJavaScriptEnabled(true);
webView.loadUrl("https://www.tust.edu.cn");
