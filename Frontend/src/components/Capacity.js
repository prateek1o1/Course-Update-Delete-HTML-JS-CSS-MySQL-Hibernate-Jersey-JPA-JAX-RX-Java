import React, { useState } from 'react'

/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const Capacity = ({ capacity }) => {
  // States for tracking form input which are the email address and password
  const [ courseID, setCourseID ] = useState('')
  const [ newCapacity, setNewCapacity] = useState('')

  // onSubmit event handler of this form
  const handleCapacity = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const credentials = {
      courseID, newCapacity
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    capacity(credentials)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setCourseID('')
    setNewCapacity('')
  }

  // Typically keep id attributes on your HTML elements so that they can be styled using CSS
  return (
    <form onSubmit={handleCapacity} id='login-form' align="center">
      <input 
        type='courseID'
        placeholder='COURSE IDENTITY'
        // Note that the text that's displayed on the textbox (value attribute) is controlled by the email state
        value={courseID}
        // onChange event handler
        // When you type something on the textbox, the onChange event handler will be triggered
        // This event handler as written below, updates the email state with what's being typed by the user
        // Because a state has been updated, the form component will be re-rendered and you can see the updated input
        // on the screen, obviously this happens so fast that you cannot see it but this is the entire procedure
        onChange={event => setCourseID(event.target.value)}
        id='courseID'
        required
      />
        <br></br>
      {/* Same as the above username input, except this one has the type password */}
      <input
        type='newCapacity'
        placeholder='ALLOWED INTAKE OF STUDENTS'
        value={newCapacity}
        onChange={event => setNewCapacity(event.target.value)}
        id='newCapacity'
        required
      />
    <br></br>
      {/* Submit button for the form */}
      <button type='submit' id='capacity-submit'><i>UPDATE</i></button>
    </form>
  )
}

export default Capacity