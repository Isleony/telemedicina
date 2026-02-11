import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import { 
  Home, 
  Users, 
  Calendar, 
  Video, 
  Activity, 
  Building2,
  Menu,
  X
} from 'lucide-react'
import { useState } from 'react'
import Dashboard from './pages/Dashboard'
import Patients from './pages/Patients'
import Appointments from './pages/Appointments'
import Telemedicine from './pages/Telemedicine'
import Oncology from './pages/Oncology'

function App() {
  const [sidebarOpen, setSidebarOpen] = useState(true)

  return (
    <Router>
      <div className="flex h-screen bg-gray-100">
        {/* Sidebar */}
        <aside className={`${sidebarOpen ? 'w-64' : 'w-20'} bg-primary-700 text-white transition-all duration-300 flex flex-col`}>
          <div className="p-4 flex items-center justify-between">
            {sidebarOpen && (
              <div className="flex items-center gap-2">
                <Building2 className="w-8 h-8" />
                <h1 className="font-bold text-lg">HospitalCare</h1>
              </div>
            )}
            <button 
              onClick={() => setSidebarOpen(!sidebarOpen)}
              className="p-2 hover:bg-primary-600 rounded"
            >
              {sidebarOpen ? <X size={20} /> : <Menu size={20} />}
            </button>
          </div>

          <nav className="flex-1 px-2 py-4 space-y-2">
            <NavLink to="/" icon={<Home size={20} />} label="Dashboard" sidebarOpen={sidebarOpen} />
            <NavLink to="/pacientes" icon={<Users size={20} />} label="Pacientes" sidebarOpen={sidebarOpen} />
            <NavLink to="/agendamentos" icon={<Calendar size={20} />} label="Agendamentos" sidebarOpen={sidebarOpen} />
            <NavLink to="/telemedicina" icon={<Video size={20} />} label="Telemedicina" sidebarOpen={sidebarOpen} />
            <NavLink to="/oncologia" icon={<Activity size={20} />} label="Oncologia" sidebarOpen={sidebarOpen} />
          </nav>

          {sidebarOpen && (
            <div className="p-4 border-t border-primary-600">
              <p className="text-sm text-primary-200">v1.0.0 - Java 21</p>
            </div>
          )}
        </aside>

        {/* Main Content */}
        <main className="flex-1 overflow-auto bg-gray-100">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/pacientes" element={<Patients />} />
            <Route path="/agendamentos" element={<Appointments />} />
            <Route path="/telemedicina" element={<Telemedicine />} />
            <Route path="/oncologia" element={<Oncology />} />
          </Routes>
        </main>
      </div>
    </Router>
  )
}

function NavLink({ to, icon, label, sidebarOpen }: { to: string; icon: React.ReactNode; label: string; sidebarOpen: boolean }) {
  return (
    <Link
      to={to}
      className="flex items-center gap-3 px-3 py-2 rounded hover:bg-primary-600 transition-colors"
      title={!sidebarOpen ? label : ''}
    >
      {icon}
      {sidebarOpen && <span>{label}</span>}
    </Link>
  )
}

export default App
