// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact to the page.
 */
function addRandomFact() {
  const facts =
      ['I debate sometimes!', 'I love The Office!', 'My nick name is Simun (See Moon)', 'PB&J are my fave (if you watch The Office;)'];

  // Pick a random greeting.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

function getJsonComments() {
    fetch('/data').then(response => response.json()).then((comments) => {
        const commentListElement = document.getElementById('my-details-container');
        comments.forEach((comment) => {
        commentListElement.appendChild(createTaskElement(comment));
        })
    });
}

function createTaskElement(comment) {
  const commentElement = document.createElement('li');
  commentElement.className = 'comment';
  const titleElement = document.createElement('span');
  titleElement.innerText = comment.title;
  commentElement.appendChild(titleElement);
  return commentElement;
}

