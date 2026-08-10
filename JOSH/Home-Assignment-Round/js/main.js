/**
 * JTGeats — Main JavaScript
 * Handles: Swiper carousel, Request Dish modal, Video player, Quantity controls
 */

document.addEventListener('DOMContentLoaded', function () {

  // ===== MOBILE HAMBURGER MENU =====
  var hamburgerBtn = document.getElementById('hamburger-btn');
  var mainNav = document.getElementById('main-nav');

  if (hamburgerBtn && mainNav) {
    hamburgerBtn.addEventListener('click', function () {
      var isOpen = mainNav.classList.toggle('header__nav--open');
      hamburgerBtn.classList.toggle('header__hamburger--active', isOpen);
      hamburgerBtn.setAttribute('aria-expanded', isOpen);
      document.body.classList.toggle('modal-open', isOpen);
    });

    // Close menu when a nav link is clicked
    mainNav.querySelectorAll('a').forEach(function (link) {
      link.addEventListener('click', function () {
        mainNav.classList.remove('header__nav--open');
        hamburgerBtn.classList.remove('header__hamburger--active');
        hamburgerBtn.setAttribute('aria-expanded', 'false');
        document.body.classList.remove('modal-open');
      });
    });
  }

  // ===== SWIPER CAROUSEL =====
  if (window.Swiper) {
    const popularSwiper = new Swiper('#popular-swiper', {
      slidesPerView: 3,
      spaceBetween: 38,
      centeredSlides: true,
      centeredSlidesBounds: true,
      loop: true,
      autoplay: {
        delay: 5000,
        disableOnInteraction: false,
      },
      speed: 300,
      navigation: {
        prevEl: '#carousel-prev',
        nextEl: '#carousel-next',
      },
      breakpoints: {
        0: { slidesPerView: 1, spaceBetween: 38 },
        640: { slidesPerView: 2, spaceBetween: 38 },
        1024: { slidesPerView: 3, spaceBetween: 38 },
      },
    });
  }

  // ===== REQUEST DISH MODAL =====
  var modalOverlay = document.getElementById('modal-overlay');
  var btnRequestDish = document.getElementById('btn-request-dish-old');
  var btnSubmitRequest = document.getElementById('btn-submit-request');
  var btnModalCancel = document.getElementById('modal-cancel');
  var modalForm = document.getElementById('modal-form');

  function openModal() {
    if (!modalOverlay) {
      return;
    }
    modalOverlay.classList.add('active');
    document.body.classList.add('modal-open');
  }

  function closeModal() {
    if (!modalOverlay) {
      return;
    }
    modalOverlay.classList.remove('active');
    document.body.classList.remove('modal-open');
    if (modalForm) {
      modalForm.reset();
    }
  }

  if (btnRequestDish) {
    btnRequestDish.addEventListener('click', openModal);
  }
  if (btnSubmitRequest) {
    btnSubmitRequest.addEventListener('click', closeModal);
  }
  if (btnModalCancel) {
    btnModalCancel.addEventListener('click', closeModal);
  }

  // Close on overlay click (not modal body)
  if (modalOverlay) {
    modalOverlay.addEventListener('click', function (e) {
      if (e.target === modalOverlay) {
        closeModal();
      }
    });
  }

  // Close on Escape key
  document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape' && modalOverlay.classList.contains('active')) {
      closeModal();
    }
  });

  // Submit handler — close modal (no data storage required)
  if (modalForm) {
    modalForm.addEventListener('submit', function (e) {
      e.preventDefault();
      closeModal();
    });
  }

  // ===== VIDEO PLAYER =====
  var videoPlayer = document.getElementById('video-player');
  var video = document.getElementById('food-video');
  var videoOverlay = document.getElementById('video-overlay');

  if (videoPlayer && video) {
    videoPlayer.addEventListener('click', function () {
      if (video.paused) {
        video.play();
        videoPlayer.classList.add('playing');
      } else {
        video.pause();
        videoPlayer.classList.remove('playing');
      }
    });

    // Show play button when video ends
    video.addEventListener('ended', function () {
      videoPlayer.classList.remove('playing');
    });
  }

  // ===== QUANTITY CONTROLS =====
  function createCartControls(initialQty) {
    var controls = document.createElement('div');
    controls.className = 'product-card__cart-controls';
    controls.innerHTML =
      '<img src="assets/svgs/item-decreaser.svg" alt="decrease" class="qty-decrease" />' +
      '<span class="product-card__qty">' + initialQty + '</span>' +
      '<img src="assets/svgs/item-increaser.svg" alt="increase" class="qty-increase" />';
    return controls;
  }

  function createAddButton() {
    var btn = document.createElement('div');
    btn.className = 'product-card__add-btn';
    btn.innerHTML = '<img src="assets/svgs/item-increaser.svg" alt="Add to cart" />';
    return btn;
  }

  document.addEventListener('click', function (e) {
    var addBtn = e.target.closest('.product-card__add-btn');
    if (addBtn) {
      var controls = createCartControls(1);
      addBtn.replaceWith(controls);
      return;
    }

    if (e.target.classList.contains('qty-increase')) {
      var qtyEl = e.target.previousElementSibling;
      var val = parseInt(qtyEl.textContent, 10);
      qtyEl.textContent = val + 1;
      return;
    }

    if (e.target.classList.contains('qty-decrease')) {
      var qtyEl = e.target.nextElementSibling;
      var val = parseInt(qtyEl.textContent, 10);
      if (val > 1) {
        qtyEl.textContent = val - 1;
      } else {
        var controlsWrap = e.target.closest('.product-card__cart-controls');
        if (controlsWrap) {
          controlsWrap.replaceWith(createAddButton());
        }
      }
    }
  });

  // ===== SMOOTH SCROLL FOR NAV =====
  document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
    anchor.addEventListener('click', function (e) {
      var target = document.querySelector(this.getAttribute('href'));
      if (target) {
        e.preventDefault();
        target.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    });
  });
});
