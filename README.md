# 207GPT

This app allows the user to enter a list which it then stores in a priority queue implemented with a max heap, 
or sorts with heap stort depending on user input. Note that the user must type "done" to confirm the list. Clicking 
the buttons triggers an audio file to ensure accessiblity for deaf persons.

<br/>
<h2>Use Cases:</h2>
<ul>
  <li>StoreInPriorityQueue returns the user's inputted list in a priority queue</li>
  <li>IncreaseKey allows the user to edit a value in their list</li>
  <li>SortInput returns a list sorted with heap sort</li>
</ul>

<br />
<h2>Design Patterns:</h2>
<ul>
  <li>Builder: ButtonPanelBuilder in util constructs the button panel used in PromptView</li>
  <li>Strategy: SortStrategy uses strategy design pattern</li>
</ul>

<h2>Program Specifications</h2>
<ul>
  <li>Java version: Java 11</li>
  <li>Testing framework: Maven</li>
  <li>
    There are no notable code smells other than perhaps the long PromptView class. We adhere to SOLID and CA but 
    don't include intermediate layers of abstraction (input boundaries etc.).
  </li>
</ul>
