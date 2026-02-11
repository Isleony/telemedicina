import { Calendar, Plus } from 'lucide-react'

export default function Appointments() {
  return (
    <div className="p-8 bg-gray-100 min-h-screen">
      <div className="mb-8 flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold text-gray-800">Agendamentos</h1>
          <p className="text-gray-600">Gestão de consultas e procedimentos</p>
        </div>
        <button className="bg-primary-600 text-white px-4 py-2 rounded-lg flex items-center gap-2 hover:bg-primary-700">
          <Plus size={20} />
          Novo Agendamento
        </button>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Today's Appointments */}
        <div className="lg:col-span-2 bg-white rounded-lg shadow">
          <div className="p-6 border-b">
            <h2 className="text-xl font-semibold flex items-center gap-2">
              <Calendar className="text-primary-600" />
              Hoje - 11 de Fevereiro, 2026
            </h2>
          </div>
          <div className="p-6 space-y-4">
            <AppointmentCard
              time="09:00"
              patient="Maria Silva Santos"
              doctor="Dr. João Santos"
              specialty="Cardiologia"
              type="PRESENCIAL"
              status="CONFIRMADA"
            />
            <AppointmentCard
              time="10:30"
              patient="Pedro Oliveira"
              doctor="Dra. Ana Costa"
              specialty="Oncologia"
              type="PRESENCIAL"
              status="AGENDADA"
            />
            <AppointmentCard
              time="14:00"
              patient="Carla Souza"
              doctor="Dr. Carlos Lima"
              specialty="Clínica Geral"
              type="TELEMEDICINA"
              status="CONFIRMADA"
            />
            <AppointmentCard
              time="15:30"
              patient="Roberto Alves"
              doctor="Dr. João Santos"
              specialty="Cardiologia"
              type="PRESENCIAL"
              status="EM_ANDAMENTO"
            />
          </div>
        </div>

        {/* Quick Stats */}
        <div className="space-y-6">
          <div className="bg-white rounded-lg shadow p-6">
            <h3 className="font-semibold mb-4">Estatísticas do Dia</h3>
            <div className="space-y-3">
              <StatItem label="Total" value="42" color="text-blue-600" />
              <StatItem label="Confirmadas" value="35" color="text-green-600" />
              <StatItem label="Em Andamento" value="3" color="text-yellow-600" />
              <StatItem label="Concluídas" value="28" color="text-purple-600" />
              <StatItem label="Canceladas" value="4" color="text-red-600" />
            </div>
          </div>

          <div className="bg-white rounded-lg shadow p-6">
            <h3 className="font-semibold mb-4">Por Especialidade</h3>
            <div className="space-y-3">
              <StatItem label="Cardiologia" value="8" />
              <StatItem label="Oncologia" value="12" />
              <StatItem label="Clínica Geral" value="15" />
              <StatItem label="Pediatria" value="7" />
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

function AppointmentCard({
  time,
  patient,
  doctor,
  specialty,
  type,
  status
}: {
  time: string
  patient: string
  doctor: string
  specialty: string
  type: string
  status: string
}) {
  const statusColors = {
    AGENDADA: 'bg-blue-100 text-blue-800',
    CONFIRMADA: 'bg-green-100 text-green-800',
    EM_ANDAMENTO: 'bg-yellow-100 text-yellow-800',
    CONCLUIDA: 'bg-purple-100 text-purple-800',
    CANCELADA: 'bg-red-100 text-red-800'
  }

  return (
    <div className="border border-gray-200 rounded-lg p-4 hover:shadow-md transition-shadow">
      <div className="flex items-start justify-between mb-3">
        <div className="flex items-center gap-3">
          <div className="bg-primary-100 text-primary-700 font-semibold px-3 py-1 rounded">
            {time}
          </div>
          <span className={`px-2 py-1 text-xs font-medium rounded-full ${statusColors[status as keyof typeof statusColors]}`}>
            {status}
          </span>
        </div>
        {type === 'TELEMEDICINA' && (
          <span className="bg-purple-100 text-purple-700 px-2 py-1 text-xs font-medium rounded">
            Telemedicina
          </span>
        )}
      </div>
      <div className="space-y-1">
        <p className="font-medium text-gray-900">{patient}</p>
        <p className="text-sm text-gray-600">{doctor}</p>
        <p className="text-sm text-gray-500">{specialty}</p>
      </div>
    </div>
  )
}

function StatItem({ label, value, color = 'text-gray-700' }: { label: string; value: string; color?: string }) {
  return (
    <div className="flex justify-between items-center">
      <span className="text-sm text-gray-600">{label}</span>
      <span className={`font-semibold ${color}`}>{value}</span>
    </div>
  )
}
