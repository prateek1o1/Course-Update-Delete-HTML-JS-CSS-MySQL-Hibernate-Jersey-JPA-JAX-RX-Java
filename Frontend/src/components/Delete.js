import React, { useState } from 'react'

/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const Delete = ({ deletes }) => {
  // States for tracking form input which are the email address and password
  const [ courseID, setCourseID ] = useState('')
  

  // onSubmit event handler of this form
  const handleDelete = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const credentials = {
      courseID
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    deletes(credentials)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setCourseID('')
  
  }

  // Typically keep id attributes on your HTML elements so that they can be styled using CSS
  return (
    <form onSubmit={handleDelete} id='delete-form' align="center">
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
      {/* Submit button for the form */}
      <button type='submit' id='delete-submit'><i>DELETE</i></button>
    </form>
  )

  // Styled Form
  // return (
  //   <div className='form-container'>
  //     <div className='form-box regular-shadow'>

  //       <div className='header-form'>
  //         <h4 className='text-primary text-center'>
  //           <i className='fa fa-user-circle' style={{fontSize:'110px', color: 'lightblue'}}></i>
  //         </h4>
  //         <div className='image'></div>
  //       </div>

  //       <div className='body-form'>
  //         <form onSubmit={handleLogin} id='login-form'>

  //           <div className='input-group mb-3'>
  //             <div className='input-group-prepend'>
  //               <span className='input-group-text'><i className='fa fa-user'></i></span>
  //             </div>
  //             <input 
  //               type='text'
  //               className='form-control'
  //               placeholder='Email Address'
  //               value={email}
  //               onChange={event => setEmail(event.target.value)}
  //               id='email'
  //               required
  //             />
  //           </div>

  //           <div className='input-group mb-3'>
  //             <div className='input-group-prepend'>
  //               <span className='input-group-text'><i className='fa fa-lock'></i></span>
  //             </div>
  //             <input
  //               type='password'
  //               className='form-control'
  //               placeholder='Password'
  //               value={password}
  //               onChange={event => setPassword(event.target.value)}
  //               id='password'
  //               required
  //             />
  //           </div>

  //           <button type='submit' className='btn btn-primary btn-block' id='login-submit'>LOGIN</button>
  //         </form>
  //       </div>
  //     </div>
  //   </div>   
  // )
}

export default Delete