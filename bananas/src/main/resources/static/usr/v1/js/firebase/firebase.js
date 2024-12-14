// firebase SDK - CDN

  // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/11.1.0/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/11.1.0/firebase-analytics.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
  const firebaseConfig = {
    apiKey: "AIzaSyA9bcS2hYPuVR20Z-owcogdIcGKQtnHL7g",
    authDomain: "superbad-bananas-firebase-chat.firebaseapp.com",
    databaseURL: "https://superbad-bananas-firebase-chat-default-rtdb.firebaseio.com",
    projectId: "superbad-bananas-firebase-chat",
    storageBucket: "superbad-bananas-firebase-chat.firebasestorage.app",
    messagingSenderId: "558721157440",
    appId: "1:558721157440:web:c17c952bb232556593d2a5",
    measurementId: "G-2J806W9B42"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);
