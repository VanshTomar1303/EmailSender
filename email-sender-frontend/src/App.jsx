import { Toaster } from "react-hot-toast"
import EmailSender from "./components/EmailSender"


function App() {
  

  return (
    <div className="font-mono">
      <EmailSender/>
      <Toaster/>
    </div>
  )
}

export default App
