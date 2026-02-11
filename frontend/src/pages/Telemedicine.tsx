import { Video, Clock, PlayCircle } from 'lucide-react'

export default function Telemedicine() {
  return (
    <div className="p-8">
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Telemedicina</h1>
        <p className="text-gray-600">Consultas virtuais e atendimento remoto</p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6 mb-6">
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Consultas Hoje</p>
              <p className="text-3xl font-bold text-gray-800">12</p>
            </div>
            <Video className="text-purple-600" size={40} />
          </div>
        </div>
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Em Andamento</p>
              <p className="text-3xl font-bold text-green-600">3</p>
            </div>
            <PlayCircle className="text-green-600" size={40} />
          </div>
        </div>
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Agendadas</p>
              <p className="text-3xl font-bold text-blue-600">9</p>
            </div>
            <Clock className="text-blue-600" size={40} />
          </div>
        </div>
      </div>

      {/* Active Sessions */}
      <div className="bg-white rounded-lg shadow mb-6">
        <div className="p-6 border-b">
          <h2 className="text-xl font-semibold">Sessões Ativas</h2>
        </div>
        <div className="p-6">
          <div className="space-y-4">
            <TeleconsultationCard
              patient="Maria Silva Santos"
              doctor="Dr. João Santos"
              startTime="14:00"
              duration="15 min"
              status="EM_ANDAMENTO"
            />
            <TeleconsultationCard
              patient="Carlos Eduardo Lima"
              doctor="Dra. Ana Costa"
              startTime="14:30"
              duration="8 min"
              status="EM_ANDAMENTO"
            />
            <TeleconsultationCard
              patient="Juliana Ferreira"
              doctor="Dr. Pedro Alves"
              startTime="15:00"
              duration="3 min"
              status="EM_ANDAMENTO"
            />
          </div>
        </div>
      </div>

      {/* Upcoming Sessions */}
      <div className="bg-white rounded-lg shadow">
        <div className="p-6 border-b">
          <h2 className="text-xl font-semibold">Próximas Consultas</h2>
        </div>
        <div className="p-6">
          <div className="space-y-4">
            <TeleconsultationCard
              patient="Roberto Alves"
              doctor="Dr. João Santos"
              startTime="16:00"
              status="AGENDADA"
            />
            <TeleconsultationCard
              patient="Patricia Souza"
              doctor="Dra. Ana Costa"
              startTime="16:30"
              status="AGENDADA"
            />
            <TeleconsultationCard
              patient="Fernando Santos"
              doctor="Dr. Carlos Lima"
              startTime="17:00"
              status="CONFIRMADA"
            />
          </div>
        </div>
      </div>
    </div>
  )
}

function TeleconsultationCard({
  patient,
  doctor,
  startTime,
  duration,
  status
}: {
  patient: string
  doctor: string
  startTime: string
  duration?: string
  status: string
}) {
  const isActive = status === 'EM_ANDAMENTO'

  return (
    <div className={`border rounded-lg p-4 ${isActive ? 'border-green-500 bg-green-50' : 'border-gray-200'}`}>
      <div className="flex items-center justify-between">
        <div className="flex-1">
          <div className="flex items-center gap-3 mb-2">
            <span className="text-sm font-medium text-gray-700">{startTime}</span>
            {duration && (
              <span className="text-sm text-gray-600">• {duration}</span>
            )}
            {isActive && (
              <span className="flex items-center gap-1">
                <span className="w-2 h-2 bg-green-500 rounded-full animate-pulse"></span>
                <span className="text-sm font-medium text-green-700">AO VIVO</span>
              </span>
            )}
          </div>
          <p className="font-medium text-gray-900">{patient}</p>
          <p className="text-sm text-gray-600">{doctor}</p>
        </div>
        {isActive ? (
          <button className="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700 flex items-center gap-2">
            <Video size={18} />
            Entrar
          </button>
        ) : (
          <button className="bg-primary-600 text-white px-4 py-2 rounded-lg hover:bg-primary-700">
            Iniciar
          </button>
        )}
      </div>
    </div>
  )
}
