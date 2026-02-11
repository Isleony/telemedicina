import { Users, Calendar, Video, Activity, TrendingUp, Clock } from 'lucide-react'

export default function Dashboard() {
  return (
    <div className="p-8 bg-gray-100 min-h-screen">
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Dashboard</h1>
        <p className="text-gray-600">Visão geral do sistema hospitalar</p>
      </div>

      {/* Stats Grid */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
        <StatCard
          icon={<Users className="text-blue-600" />}
          title="Total de Pacientes"
          value="1,284"
          change="+12%"
          changeType="positive"
        />
        <StatCard
          icon={<Calendar className="text-green-600" />}
          title="Agendamentos Hoje"
          value="42"
          change="+5%"
          changeType="positive"
        />
        <StatCard
          icon={<Video className="text-purple-600" />}
          title="Teleconsultas Ativas"
          value="8"
          change="-2%"
          changeType="negative"
        />
        <StatCard
          icon={<Activity className="text-orange-600" />}
          title="Tratamentos Oncológicos"
          value="156"
          change="+8%"
          changeType="positive"
        />
      </div>

      {/* Recent Activity */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white rounded-lg shadow p-6">
          <h2 className="text-xl font-semibold mb-4 flex items-center gap-2">
            <Clock className="text-primary-600" />
            Próximos Agendamentos
          </h2>
          <div className="space-y-3">
            <AppointmentItem
              patient="Maria Silva"
              doctor="Dr. João Santos"
              time="09:00"
              specialty="Cardiologia"
            />
            <AppointmentItem
              patient="Pedro Oliveira"
              doctor="Dra. Ana Costa"
              time="10:30"
              specialty="Oncologia"
            />
            <AppointmentItem
              patient="Carla Souza"
              doctor="Dr. Carlos Lima"
              time="14:00"
              specialty="Telemedicina"
            />
          </div>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h2 className="text-xl font-semibold mb-4 flex items-center gap-2">
            <TrendingUp className="text-primary-600" />
            Estatísticas da Semana
          </h2>
          <div className="space-y-4">
            <ProgressBar label="Consultas Realizadas" value={85} total={100} />
            <ProgressBar label="Taxa de Ocupação" value={72} total={100} />
            <ProgressBar label="Teleconsultas" value={45} total={60} />
            <ProgressBar label="Tratamentos em Andamento" value={38} total={50} />
          </div>
        </div>
      </div>
    </div>
  )
}

function StatCard({ 
  icon, 
  title, 
  value, 
  change, 
  changeType 
}: { 
  icon: React.ReactNode
  title: string
  value: string
  change: string
  changeType: 'positive' | 'negative'
}) {
  return (
    <div className="bg-white rounded-lg shadow p-6">
      <div className="flex items-center justify-between mb-2">
        {icon}
        <span className={`text-sm font-medium ${
          changeType === 'positive' ? 'text-green-600' : 'text-red-600'
        }`}>
          {change}
        </span>
      </div>
      <h3 className="text-gray-600 text-sm mb-1">{title}</h3>
      <p className="text-3xl font-bold text-gray-800">{value}</p>
    </div>
  )
}

function AppointmentItem({
  patient,
  doctor,
  time,
  specialty
}: {
  patient: string
  doctor: string
  time: string
  specialty: string
}) {
  return (
    <div className="flex items-center justify-between p-3 bg-gray-50 rounded-lg">
      <div>
        <p className="font-medium text-gray-800">{patient}</p>
        <p className="text-sm text-gray-600">{doctor} - {specialty}</p>
      </div>
      <span className="text-sm font-medium text-primary-600">{time}</span>
    </div>
  )
}

function ProgressBar({ label, value, total }: { label: string; value: number; total: number }) {
  const percentage = (value / total) * 100
  
  return (
    <div>
      <div className="flex justify-between mb-1">
        <span className="text-sm text-gray-600">{label}</span>
        <span className="text-sm font-medium text-gray-800">{value}/{total}</span>
      </div>
      <div className="w-full bg-gray-200 rounded-full h-2">
        <div 
          className="bg-primary-600 h-2 rounded-full transition-all duration-300"
          style={{ width: `${percentage}%` }}
        />
      </div>
    </div>
  )
}
