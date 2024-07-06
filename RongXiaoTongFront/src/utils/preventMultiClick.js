export default {
    install(Vue) {
      Vue.directive('preventMultiClick', {
        inserted(el_button, bind) {
          el_button.addEventListener('click', () => {
            if (!el_button.disabled) {
              el_button.disabled = true;
              setTimeout(() => {
                el_button.disabled = false
              }, bind.value||500)
            }
          })
        }
      })
    }
  }