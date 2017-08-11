import Vue from 'vue'
import test from './components/test.vue'

new Vue({
    el: '#test',
    template: '<test/>',
    components: {'test':test}
});